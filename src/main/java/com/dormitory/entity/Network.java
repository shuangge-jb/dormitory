package com.dormitory.entity;


public class Network {
    private Long studentId;

    private String tariffPackage;

    private Integer money;

    public Long getSutdentId() {
        return studentId;
    }

    public void setSutdentId(Long sutdentId) {
        this.studentId = sutdentId;
    }

    public String getTariffPackage() {
        return tariffPackage;
    }

    public void setTariffPackage(String tariffPackage) {
        this.tariffPackage = tariffPackage == null ? null : tariffPackage.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sutdentId=").append(studentId);
        sb.append(", tariffPackage=").append(tariffPackage);
        sb.append(", money=").append(money);
        sb.append("]");
        return sb.toString();
    }
}