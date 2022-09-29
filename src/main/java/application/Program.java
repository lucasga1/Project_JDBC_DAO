package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("===== TEST 1: seller findById ===== ");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
