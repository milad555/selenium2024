package api;

public class UnsuccessReg {

    private String error;

    public UnsuccessReg() {}
    public UnsuccessReg(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
