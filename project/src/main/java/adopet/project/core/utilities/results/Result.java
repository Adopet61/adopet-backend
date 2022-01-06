package adopet.project.core.utilities.results;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    } //Başarılı mı

    public Result(boolean success, String message) { //Başarılı mı ve işlem sonucundaki mesaj
        this(success);
        this.message = message;
    }
    //Dışarıdan erişim için getter
    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}
