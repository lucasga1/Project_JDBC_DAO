package model.util;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CreateSellerFindAll {

    public static void createUser() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Digite os dados do Seller que deseja inserir: ");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.print("Birth Date: ");
        Date date = sdf.parse(sc.next());

        System.out.print("Base Salary: R$");
        double baseSalary = sc.nextDouble();

        System.out.print("Department Id: ");
        int dep = sc.nextInt();
        System.out.println();
        Department department = new Department(dep, null);

        Seller newSeller = new Seller(null, name, email, date, baseSalary, department);

        sellerDao.insert(newSeller);

        List<Seller> list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj.getName());
        }
    }
}
