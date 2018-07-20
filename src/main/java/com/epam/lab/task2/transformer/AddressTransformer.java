package com.epam.lab.task2.transformer;

import com.epam.lab.task2.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AddressTransformer {

    public static Address transformToAddress(ResultSet resultSet) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Address(
                    resultSet.getInt("address_id"),
                    resultSet.getString("country"),
                    resultSet.getString("region"),
                    resultSet.getString("city"),
                    resultSet.getString("street"),
                    resultSet.getString("house"),
                    resultSet.getInt("apartment"));
        }
        return new Address();
    }

    public static PreparedStatement transformToStatement(Connection connection, Address address) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO address(address_id, `country`, `region`, `city`, `street`, `house`, `apartment`) VALUES (?,?,?,?,?,?,?);");
        statement.setInt(1, address.getId());
        statement.setString(2, address.getCountry());
        statement.setString(3, address.getRegion());
        statement.setString(4, address.getCity());
        statement.setString(5, address.getStreet());
        statement.setString(6, address.getHouse());
        statement.setInt(7, address.getApartment());
        return statement;
    }
}
