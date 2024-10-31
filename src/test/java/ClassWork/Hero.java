package ClassWork;

public class Hero {
    public String name;
    private String secretIdentity;

    public Hero(String superName, String secretIdentity){
        this.name = superName;
        this.secretIdentity= secretIdentity;
    }
    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }


    public void fightCrime(){
        System.out.println(name + " is fightning for truth and justice");
    }
    public String savePeople(int ppl){
        return "Saved " + ppl;
    }
}
