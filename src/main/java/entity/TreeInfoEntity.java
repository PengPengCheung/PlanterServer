package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "tree_info", schema = "PlanterDatabase", catalog = "")
public class TreeInfoEntity {
    private String treeId;
    private int treeStatus;
    private int treeSoil;
    private int treeWater;
    private int treeSun;
    private int treeSunUsedNum;
    private int tree_water_used_num;
    private int treeSoilUsedNum;

    @Id
    @Column(name = "tree_id")
    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    @Basic
    @Column(name = "tree_status")
    public int getTreeStatus() {
        return treeStatus;
    }

    public void setTreeStatus(int treeStatus) {
        this.treeStatus = treeStatus;
    }

    @Basic
    @Column(name = "tree_soil")
    public int getTreeSoil() {
        return treeSoil;
    }

    public void setTreeSoil(int treeSoil) {
        this.treeSoil = treeSoil;
    }

    @Basic
    @Column(name = "tree_water")
    public int getTreeWater() {
        return treeWater;
    }

    public void setTreeWater(int treeWater) {
        this.treeWater = treeWater;
    }

    @Basic
    @Column(name = "tree_sun")
    public int getTreeSun() {
        return treeSun;
    }

    public void setTreeSun(int treeSun) {
        this.treeSun = treeSun;
    }

    @Basic
    @Column(name = "tree_sun_used_num")
    public Integer getTreeSunUsedNum() {
        return treeSunUsedNum;
    }

    public void setTreeSunUsedNum(Integer treeSunUsedNum) {
        this.treeSunUsedNum = treeSunUsedNum;
    }

    @Basic
    @Column(name = "tree_water_used_num")
    public Integer getTreeWaterUsedNum() {
        return tree_water_used_num;
    }

    public void setTreeWaterUsedNum(Integer treeWaterUsedNum) {
        this.tree_water_used_num = treeWaterUsedNum;
    }

    @Basic
    @Column(name = "tree_soil_used_num")
    public Integer getTreeSoilUsedNum() {
        return treeSoilUsedNum;
    }

    public void setTreeSoilUsedNum(Integer treeSoilUsedNum) {
        this.treeSoilUsedNum = treeSoilUsedNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeInfoEntity that = (TreeInfoEntity) o;

        if (treeStatus != that.treeStatus) return false;
        if (treeSoil != that.treeSoil) return false;
        if (treeWater != that.treeWater) return false;
        if (treeSun != that.treeSun) return false;
        if (treeSunUsedNum != that.treeSunUsedNum) return false;
        if (tree_water_used_num != that.tree_water_used_num) return false;
        if (treeSoilUsedNum != that.treeSoilUsedNum) return false;
        if (treeId != null ? !treeId.equals(that.treeId) : that.treeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treeId != null ? treeId.hashCode() : 0;
        result = 31 * result + treeStatus;
        result = 31 * result + treeSoil;
        result = 31 * result + treeWater;
        result = 31 * result + treeSun;
        result = 31 * result + treeSunUsedNum;
        result = 31 * result + tree_water_used_num;
        result = 31 * result + treeSoilUsedNum;
        return result;
    }
}
