package com.monegoo.converter.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="crypto_currencies")
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "timestamp", nullable = false, scale = 10, precision = 25)
    Long timestamp;

    @Column(name = "BTC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BTC;

    @Column(name = "ETH_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ETH;

    @Column(name = "USDT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal USDT;

    @Column(name = "BNB_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BNB;

    @Column(name = "USDC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal USDC;

    @Column(name = "XRP_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XRP;

    @Column(name = "ADA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ADA;

    @Column(name = "DOGE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal DOGE;

    @Column(name = "SOL_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal SOL;

    @Column(name = "TRX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal TRX;

    @Column(name = "LTC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LTC;

    @Column(name = "MATIC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal MATIC;

    @Column(name = "DOT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal DOT;

    @Column(name = "TON_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal TON;

    @Column(name = "WBTC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal WBTC;

    @Column(name = "DAI_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal DAI;

    @Column(name = "SHIB_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal SHIB;

    @Column(name = "AVAX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal AVAX;

    @Column(name = "BUSD_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BUSD;

    @Column(name = "BCH_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BCH;

    @Column(name = "LEO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LEO;

    @Column(name = "LINK_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LINK;

    @Column(name = "ATOM_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ATOM;

    @Column(name = "TUSD_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal TUSD;

    @Column(name = "UNI_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal UNI;

    @Column(name = "XMR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XMR;

    @Column(name = "OKB_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal OKB;

    @Column(name = "ETC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ETC;

    @Column(name = "XLM_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XLM;

    @Column(name = "ICP_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ICP;

    @Column(name = "FIL_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal FIL;

    @Column(name = "LDO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LDO;

    @Column(name = "HBAR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal HBAR;

    @Column(name = "APT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal APT;

    @Column(name = "CRO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CRO;

    @Column(name = "ARB_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ARB;

    @Column(name = "VET_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal VET;

    @Column(name = "NEAR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal NEAR;

    @Column(name = "QNT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal QNT;

    @Column(name = "AAVE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal AAVE;

    @Column(name = "GRT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal GRT;

    @Column(name = "STX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal STX;

    @Column(name = "ALGO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ALGO;

    @Column(name = "USDP_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal USDP;

    @Column(name = "FTM_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal FTM;

    @Column(name = "EGLD_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal EGLD;

    @Column(name = "OP_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal OP;

    @Column(name = "APE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal APE;

    @Column(name = "SAND_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal SAND;

    @Column(name = "EOS_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal EOS;

    @Column(name = "XTZ_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XTZ;

    @Column(name = "BIT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BIT;

    @Column(name = "THETA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal THETA;

    @Column(name = "IMX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal IMX;

    @Column(name = "RNDR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal RNDR;

    @Column(name = "MANA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal MANA;

    @Column(name = "RPL_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal RPL;

    @Column(name = "USDD_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal USDD;

    @Column(name = "CFX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CFX;

    @Column(name = "MKR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal MKR;

    @Column(name = "AXS_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal AXS;

    @Column(name = "BSV_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BSV;

    @Column(name = "KCS_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal KCS;

    @Column(name = "NEO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal NEO;

    @Column(name = "KAVA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal KAVA;

    @Column(name = "PEPE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal PEPE;

    @Column(name = "CRV_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CRV;

    @Column(name = "SNX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal SNX;

    @Column(name = "GALA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal GALA;

    @Column(name = "FLOW_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal FLOW;

    @Column(name = "CHZ_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CHZ;

    @Column(name = "INJ_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal INJ;

    @Column(name = "GUSD_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal GUSD;

    @Column(name = "KLAY_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal KLAY;

    @Column(name = "LUNC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LUNC;

    @Column(name = "MIOTA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal MIOTA;

    @Column(name = "ZEC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ZEC;

    @Column(name = "PAXG_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal PAXG;

    @Column(name = "GMX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal GMX;

    @Column(name = "XAUT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XAUT;

    @Column(name = "XEC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XEC;

    @Column(name = "SUI_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal SUI;

    @Column(name = "MINA_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal MINA;

    @Column(name = "BTT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal BTT;

    @Column(name = "CSPR_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CSPR;

    @Column(name = "XDC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal XDC;

    @Column(name = "HT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal HT;

    @Column(name = "FXS_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal FXS;

    @Column(name = "GT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal GT;

    @Column(name = "DASH_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal DASH;

    @Column(name = "TWT_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal TWT;

    @Column(name = "WOO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal WOO;

    @Column(name = "NEXO_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal NEXO;

    @Column(name = "RUNE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal RUNE;

    @Column(name = "ZIL_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ZIL;

    @Column(name = "CAKE_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal CAKE;

    @Column(name = "LRC_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal LRC;

    @Column(name = "INCH_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal INCH; // 1INCH

    @Column(name = "ENJ_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal ENJ;

    @Column(name = "DYDX_COIN", nullable = false, scale = 10, precision = 25)
    BigDecimal DYDX;

}
