package io.cucumber.samples.dw.service.impl;

import io.cucumber.samples.dw.domain.Address;
import io.cucumber.samples.dw.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by stlv for developerworks article
 */
@Service
public class AddressServiceImpl implements AddressService {
    private final static String baseColumnSql = "SELECT ID, CARD_NUM, REGION, COUNTRY, STATE, CITY, STREET, EXT_DETAIL ";

    private final static String countAddressSql = "SELECT COUNT(1) FROM ADDRESS ";

    private final static String queryAddressByCardNumSql = baseColumnSql + " FROM ADDRESS WHERE CARD_NUM = ? " +
            "ORDER BY ID ASC FETCH FIRST 10 ROWS ONLY ";

    private final static String queryAllAddressSql = baseColumnSql + " FROM ADDRESS ORDER BY ID ASC ";

    private final static String queryPagedAddressSql = baseColumnSql + " FROM ADDRESS ORDER BY ID ASC " +
            "OFFSET ? ROWS " +
            "FETCH FIRST ? ROWS ONLY ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long countAddress(String cardNum) {
        Long count;
        if (null == cardNum) {
            count = jdbcTemplate.queryForObject(countAddressSql, Long.class);
        } else {
            count = jdbcTemplate.queryForObject(
                    countAddressSql + " WHERE CARD_NUM = ? "
                    , new Object[]{cardNum}, Long.class
            );
        }
        return count;
    }

    @Override
    public List<Address> queryAddressesByCardNum(String cardNum) {
        List<Address> addressList = jdbcTemplate.query(queryAddressByCardNumSql, new Object[]{cardNum},
                new BeanPropertyRowMapper<>(Address.class));
        return addressList;
    }

    @Override
    public List<Address> queryAllAddress() {
        List<Address> addressList = jdbcTemplate.query(queryAllAddressSql, new Object[]{},
                new BeanPropertyRowMapper<>(Address.class));
        return addressList;
    }

    @Override
    public List<Address> queryPagedAddress(Integer offSet, Integer pageSize) {
        List<Address> addressList = jdbcTemplate.query(queryPagedAddressSql, new Object[]{offSet, pageSize},
                new BeanPropertyRowMapper<>(Address.class));
        return addressList;
    }
}
