package com.monegoo.converter.db;

import com.monegoo.converter.db.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Integer> {

    String FIND_CRYPTO_CURRENCY_HISTORY = """
            select unix_timestamp(date(from_unixtime(timestamp))) as id,
                unix_timestamp(date(from_unixtime(timestamp))) as `timestamp`,
            	avg(aave_coin) as aave_coin,
            	avg(ada_coin) as ada_coin,
            	avg(algo_coin) as algo_coin,
            	avg(ape_coin) as ape_coin,
            	avg(apt_coin) as apt_coin,
            	avg(arb_coin) as arb_coin,
            	avg(atom_coin) as atom_coin,
            	avg(avax_coin) as avax_coin,
            	avg(axs_coin) as axs_coin,
            	avg(bch_coin) as bch_coin,
            	avg(bit_coin) as bit_coin,
            	avg(bnb_coin) as bnb_coin,
            	avg(bsv_coin) as bsv_coin,
            	avg(btc_coin) as btc_coin,
            	avg(btt_coin) as btt_coin,
            	avg(busd_coin) as busd_coin,
            	avg(cake_coin) as cake_coin,
            	avg(cfx_coin) as cfx_coin,
            	avg(chz_coin) as chz_coin,
            	avg(cro_coin) as cro_coin,
            	avg(crv_coin) as crv_coin,
            	avg(cspr_coin) as cspr_coin,
            	avg(dai_coin) as dai_coin,
            	avg(dash_coin) as dash_coin,
            	avg(doge_coin) as doge_coin,
            	avg(dot_coin) as dot_coin,
            	avg(dydx_coin) as dydx_coin,
            	avg(egld_coin) as egld_coin,
            	avg(enj_coin) as enj_coin,
            	avg(eos_coin) as eos_coin,
            	avg(etc_coin) as etc_coin,
            	avg(eth_coin) as eth_coin,
            	avg(fil_coin) as fil_coin,
            	avg(flow_coin) as flow_coin,
            	avg(ftm_coin) as ftm_coin,
            	avg(fxs_coin) as fxs_coin,
            	avg(gala_coin) as gala_coin,
            	avg(gmx_coin) as gmx_coin,
            	avg(grt_coin) as grt_coin,
            	avg(gt_coin) as gt_coin,
            	avg(gusd_coin) as gusd_coin,
            	avg(hbar_coin) as hbar_coin,
            	avg(ht_coin) as ht_coin,
            	avg(icp_coin) as icp_coin,
            	avg(imx_coin) as imx_coin,
            	avg(inch_coin) as inch_coin,
            	avg(inj_coin) as inj_coin,
            	avg(kava_coin) as kava_coin,
            	avg(kcs_coin) as kcs_coin,
            	avg(klay_coin) as klay_coin,
            	avg(ldo_coin) as ldo_coin,
            	avg(leo_coin) as leo_coin,
            	avg(link_coin) as link_coin,
            	avg(lrc_coin) as lrc_coin,
            	avg(ltc_coin) as ltc_coin,
            	avg(lunc_coin) as lunc_coin,
            	avg(mana_coin) as mana_coin,
            	avg(matic_coin) as matic_coin,
            	avg(mina_coin) as mina_coin,
            	avg(miota_coin) as miota_coin,
            	avg(mkr_coin) as mkr_coin,
            	avg(near_coin) as near_coin,
            	avg(neo_coin) as neo_coin,
            	avg(nexo_coin) as nexo_coin,
            	avg(okb_coin) as okb_coin,
            	avg(op_coin) as op_coin,
            	avg(paxg_coin) as paxg_coin,
            	avg(pepe_coin) as pepe_coin,
            	avg(qnt_coin) as qnt_coin,
            	avg(rndr_coin) as rndr_coin,
            	avg(rpl_coin) as rpl_coin,
            	avg(rune_coin) as rune_coin,
            	avg(sand_coin) as sand_coin,
            	avg(shib_coin) as shib_coin,
            	avg(snx_coin) as snx_coin,
            	avg(sol_coin) as sol_coin,
            	avg(stx_coin) as stx_coin,
            	avg(sui_coin) as sui_coin,
            	avg(theta_coin) as theta_coin,
            	avg(ton_coin) as ton_coin,
            	avg(trx_coin) as trx_coin,
            	avg(tusd_coin) as tusd_coin,
            	avg(twt_coin) as twt_coin,
            	avg(uni_coin) as uni_coin,
            	avg(usdc_coin) as usdc_coin,
            	avg(usdd_coin) as usdd_coin,
            	avg(usdp_coin) as usdp_coin,
            	avg(usdt_coin) as usdt_coin,
            	avg(vet_coin) as vet_coin,
            	avg(wbtc_coin) as wbtc_coin,
            	avg(woo_coin) as woo_coin,
            	avg(xaut_coin) as xaut_coin,
            	avg(xdc_coin) as xdc_coin,
            	avg(xec_coin) as xec_coin,
            	avg(xlm_coin) as xlm_coin,
            	avg(xmr_coin) as xmr_coin,
            	avg(xrp_coin) as xrp_coin,
            	avg(xtz_coin) as xtz_coin,
            	avg(zec_coin) as zec_coin,
            	avg(zil_coin) as zil_coin
            	from crypto_currencies where timestamp >= :from and timestamp <= :to
            group by unix_timestamp(date(from_unixtime(timestamp)))
            """;

    CryptoCurrency findTopByOrderByIdDesc();

    @Query(value = FIND_CRYPTO_CURRENCY_HISTORY, nativeQuery = true)
    List<CryptoCurrency> findCryptoCurrenciesByDates(@Param("from") Long from, @Param("to") Long to);
}
