package com.nexsoft.myapplicationmvp.core.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(tableName = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "productCode")
    @JsonProperty("productCode")
    private String productCode;
    @ColumnInfo(name = "productName")
    @JsonProperty("productName")
    private String productName;
    @ColumnInfo(name = "UOMLevel")
    @JsonProperty("UOMLevel")
    private int UOMLevel;
    @ColumnInfo(name = "uom1")
    @JsonProperty("uom1")
    private String uom1;
    @ColumnInfo(name = "uom2")
    @JsonProperty("uom2")
    private String uom2;
    @ColumnInfo(name = "uom3")
    @JsonProperty("uom3")
    private String uom3;
    @ColumnInfo(name = "uom4")
    @JsonProperty("uom4")
    private String uom4;
    @ColumnInfo(name = "conversion1to4")
    @JsonProperty("conversion1to4")
    private int conversion1to4;
    @ColumnInfo(name = "conversion2to4")
    @JsonProperty("conversion2to4")
    private int conversion2to4;
    @ColumnInfo(name = "conversion3to4")
    @JsonProperty("conversion3to4")
    private int conversion3to4;
    @ColumnInfo(name = "sellingPriceUom1")
    @JsonProperty("sellingPriceUom1")
    private double sellingPriceUom1;
    @ColumnInfo(name = "stock")
    @JsonProperty("stock")
    private int stock;
    @ColumnInfo(name = "stockFreeGood")
    @JsonProperty("stockFreeGood")
    private int stockFreeGood;
    @ColumnInfo(name = "stockcanvass")
    @JsonProperty("stockCanvass")
    private int stockCanvass;
    @ColumnInfo(name = "stockdistributor")
    @JsonProperty("stockdistributor")
    private int stockDistributor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUOMLevel() {
        return UOMLevel;
    }

    public void setUOMLevel(int UOMLevel) {
        this.UOMLevel = UOMLevel;
    }

    public int getConversion1to4() {
        return conversion1to4;
    }

    public void setConversion1to4(int conversion1to4) {
        this.conversion1to4 = conversion1to4;
    }

    public int getConversion2to4() {
        return conversion2to4;
    }

    public void setConversion2to4(int conversion2to4) {
        this.conversion2to4 = conversion2to4;
    }

    public int getConversion3to4() {
        return conversion3to4;
    }

    public void setConversion3to4(int conversion3to4) {
        this.conversion3to4 = conversion3to4;
    }

    public double getSellingPriceUom1() {
        return sellingPriceUom1;
    }

    public void setSellingPriceUom1(double sellingPriceUom1) {
        this.sellingPriceUom1 = sellingPriceUom1;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockFreeGood() {
        return stockFreeGood;
    }

    public void setStockFreeGood(int stockFreeGood) {
        this.stockFreeGood = stockFreeGood;
    }

    public int getStockCanvass() {
        return stockCanvass;
    }

    public void setStockCanvass(int stockCanvass) {
        this.stockCanvass = stockCanvass;
    }

    public int getStockDistributor() {
        return stockDistributor;
    }

    public void setStockDistributor(int stockDistributor) {
        this.stockDistributor = stockDistributor;
    }

    public String getUom1() {
        return uom1;
    }

    public void setUom1(String uom1) {
        this.uom1 = uom1;
    }

    public String getUom2() {
        return uom2;
    }

    public void setUom2(String uom2) {
        this.uom2 = uom2;
    }

    public String getUom3() {
        return uom3;
    }

    public void setUom3(String uom3) {
        this.uom3 = uom3;
    }

    public String getUom4() {
        return uom4;
    }

    public void setUom4(String uom4) {
        this.uom4 = uom4;
    }
}