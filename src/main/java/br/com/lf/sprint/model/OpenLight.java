package br.com.lf.sprint.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "openlight")
public class OpenLight extends AbstractModel{
    @Value("0")
    private int light;

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }
}
