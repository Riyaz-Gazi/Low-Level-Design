package solid_principle;

// SRP Violation
class UserServiceViolation {

    public void createUser(String name) {
        savedToDatabase(name);
        sendEmail(name);


    }

    public void savedToDatabase(String name) {
        System.out.println("Saved user database successfully");
    }

    public void sendEmail(String name) {
        System.out.println("Email send successfully");
    }

}

class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void savedUser(String name) {
        userRepository.save(name);
        emailService.send();
    }
}

class UserRepository {
    public void save(String name) {
        System.out.println("saved user with name " + name + " database successfully");
    }
}

class EmailService {
    public void send() {
        System.out.println("Email Send successfully");
    }
}

public class SRP {
    public static void main(String[] args) {
        // SRP Violation
        UserServiceViolation userServiceViolation = new UserServiceViolation();
        userServiceViolation.createUser("riyaz");

        // SRP
        UserService userService = new UserService(new UserRepository(),new EmailService());
        userService.savedUser("Mehak");
    }
}
