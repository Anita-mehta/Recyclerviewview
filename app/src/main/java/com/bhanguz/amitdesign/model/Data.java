package com.bhanguz.amitdesign.model;

public class Data
{
    private String code;

    private String price;

    private String formatted;

    private String created_at;

    private String currency;

    private String type;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getFormatted ()
    {
        return formatted;
    }

    public void setFormatted (String formatted)
    {
        this.formatted = formatted;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", price = "+price+", formatted = "+formatted+", created_at = "+created_at+", currency = "+currency+", type = "+type+"]";
    }
}
