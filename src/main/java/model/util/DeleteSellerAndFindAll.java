package model.util;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteSellerAndFindAll {

    public static void deleteSeller() {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        List<Seller> list = new ArrayList<>();

        System.out.println("Encontre o Id na lista abaixo do Seller que deseja excluir: ");
        System.out.println();

        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.print("Digite o Id de quem deseja excluir: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        System.out.println();

        System.out.println("Lista atualizada");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            if (list == null) {
                System.out.println("Lista vazia");
            }
            System.out.println(obj);

        }

    }
}
