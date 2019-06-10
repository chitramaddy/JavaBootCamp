package com.company;

public class Gum {
    private String gumBrand;
    private String gumQuanity;

    public Gum(String gumBrand, String gumQuanity) {
        this.gumBrand = gumBrand;
        this.gumQuanity = gumQuanity;
    }

    public String getGumBrand() {
        return gumBrand;
    }

    public void setGumBrand(String gumBrand) {
        this.gumBrand = gumBrand;
    }

    public String getGumQuanity() {
        return gumQuanity;
    }

    public void setGumQuanity(String gumQuanity) {
        this.gumQuanity = gumQuanity;
    }
}
