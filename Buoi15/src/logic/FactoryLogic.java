package logic;

import entity.Factory;
import entity.Staff;
import ulti.FileUtil;

import java.util.List;
import java.util.Scanner;

public class FactoryLogic {
    private List<Factory> factoryList;
    private int totalFactory;
    public FactoryLogic(List<Factory> factoryList) {
        this.factoryList = factoryList;
    }

    public List<Factory> getFactoryList() {
        return factoryList;
    }

    public int getTotalFactory() {
        return totalFactory;
    }

    public void inputFactory() {
        System.out.println("Nhập số xưởng sản xuất muốn thêm:");
        int factoryNum = new Scanner(System.in).nextInt();
        Factory factory = null;
        for (int i = 0; i < factoryNum; i++) {
            factory = new Factory();
            factory.inputInfor();
            factoryList.add(factory);
        }
        totalFactory +=  factoryNum;
        FileUtil.writeDateToFile(factoryList, "factory.dat");
    }

    public void showFactory(){
        for (Factory factory : factoryList) {
            System.out.println(factory);
        }
    }
    public Factory findFactoryById(int factoryId) {
        for (int i = 0; i < factoryList.size(); i++) {
            if (factoryId == factoryList.get(i).getId()) {
                return factoryList.get(i);
            }
        }
        return null;
    }
}
