package realEstate.service;

import realEstate.domain.User;

public class AuthService {
    private final AdminServiceImpl adminService;
    private final SellerServiceImpl sellerService;
    private final BuyerServiceImpl buyerService;

    public AuthService(AdminServiceImpl adminService, SellerServiceImpl sellerService, BuyerServiceImpl buyerService) {
        this.adminService = adminService;
        this.sellerService = sellerService;
        this.buyerService = buyerService;
    }

    public User authenticate(String correo, String password) {
        if (correo == null || password == null) {
            return null;
        }

        User user = adminService.findByCorreo(correo);
        if (isValidUser(user, password)) {
            return user;
        }

        user = sellerService.findByCorreo(correo);
        if (isValidUser(user, password)) {
            return user;
        }

        user = buyerService.findByCorreo(correo);
        if (isValidUser(user, password)) {
            return user;
        }

        return null;
    }

    private boolean isValidUser(User user, String password) {
        return user != null && password.equals(user.getPassword()) && user.isStatus();
    }
}
