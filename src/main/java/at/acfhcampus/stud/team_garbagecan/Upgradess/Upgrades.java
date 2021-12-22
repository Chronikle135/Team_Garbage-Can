package at.acfhcampus.stud.team_garbagecan.Upgradess;

public abstract class Upgrades {
    public int income;
    public String name;
    public int amount;
    public int cost;


    public Upgrades(int income, int amount, int cost, String name) {
        this.income = income;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
    }
    public int calcincome(){
        return income*amount;
    }
}
