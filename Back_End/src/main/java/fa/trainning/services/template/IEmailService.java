package fa.trainning.services.template;

public interface IEmailService {
    public void sendPasswordResetEmail(String toEmail, String newPassword);
}
