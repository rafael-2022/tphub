/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author modesc
 */
@Entity
@Table(name = "increment")
public class Increment {

    @Id
    @Column(name = "increment")
    private Integer increment;

    /**
     * @return the increment
     */
    public Integer getIncrement() {
        return increment;
    }

    /**
     * @param increment the increment to set
     */
    public void setIncrement(Integer increment) {
        this.increment = increment;
    }
}
