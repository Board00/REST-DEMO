package KAKRABA.REST_DEMO.model;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "sniper_info")
@ApiModel(description = "Sniper Mastery Details")
public class SniperMastery
{
    @Id
    @ApiModelProperty(notes = "This is the sniper id")
    private String sniperId;
    private String sniperName;
    private String sniperAddress;
    private String sniperPhoneNumber;

    public SniperMastery()
    {

    }

    public SniperMastery(String sniperId, String sniperName,  String sniperAddress, String sniperPhoneNumber)
    {
        this.sniperId = sniperId;
        this.sniperName = sniperName;
        this.sniperAddress = sniperAddress;
        this.sniperPhoneNumber = sniperPhoneNumber;

    }
    public String getSniperId() {
        return sniperId;
    }

    public void setSniperId(String sniperId) {
        this.sniperId = sniperId;
    }
    public String getSniperName() {
        return sniperName;
    }

    public void setSniperName(String sniperName) {
        this.sniperName = sniperName;
    }

    public String getSniperAddress() {
        return sniperAddress;
    }

    public void setSniperAddress(String sniperAddress) {
        this.sniperAddress = sniperAddress;
    }
    public String getSniperPhoneNumber() {
        return sniperPhoneNumber;
    }

    public void setSniperPhoneNumber(String sniperPhoneNumber) {
        this.sniperPhoneNumber = sniperPhoneNumber;
    }




}
