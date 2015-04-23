package org.fit.pis.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="vozidlo")
public class Vozidlo 
{
    @Id
    private String reg;
	private String prod;
	private String type;
	@ManyToOne(fetch=EAGER)
    private Osoba owner;
	
    public String getProd()
    {
        return prod;
    }
    
    public boolean equals(Object other)
    {
        if (other instanceof Vozidlo)
            return ((Vozidlo) other).getReg().equals(reg);
        else
            return false;
    }
    
    public void setProd(String prod)
    {
        this.prod = prod;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getReg()
    {
        return reg;
    }
    
    public void setReg(String reg)
    {
        this.reg = reg;
    }

    public Osoba getOwner()
    {
        return owner;
    }

    public void setOwner(Osoba owner)
    {
        this.owner = owner;
    }
    
    public String toString()
    {
    	return reg;
    }
}
