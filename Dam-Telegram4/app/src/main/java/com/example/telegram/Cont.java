package com.example.telegram;

public class Cont {
    private String denumire;
    private Integer varsta;
    private String email;

    public Cont() {
    }

    public Cont(String denumire, Integer varsta, String email) {
        this.denumire = denumire;
        this.varsta = varsta;
        this.email = email;
    }

    public String getDenumire() {
        return denumire;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cont{");
        sb.append("denumire='").append(denumire).append('\'');
        sb.append(", varsta=").append(varsta);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
