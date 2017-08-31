package io.cucumber.samples.dw.service;

import io.cucumber.samples.dw.domain.Address;

import java.util.List;

/**
 * Created by stlv for developerworks article
 */
public interface AddressService {

    List<Address> queryAddressesByCardNum(String cardNum);

    List<Address> queryAllAddress();

    List<Address> queryPagedAddress(Integer offSet, Integer pageSize);

    Long countAddress(String cardNum);
}
