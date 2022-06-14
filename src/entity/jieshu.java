package entity;

public class jieshu {
    private Integer id;
    private Integer uid;
    private String library_id;
    private String jieshu;

    public jieshu() {
    }

    public jieshu(Integer id, Integer uid, String library_id, String jieshu) {
        this.id = id;
        this.uid = uid;
        this.library_id = library_id;
        this.jieshu = jieshu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(String library_id) {
        this.library_id = library_id;
    }

    public String getJieshu() {
        return jieshu;
    }

    public void setJieshu(String jieshu) {
        this.jieshu = jieshu;
    }
}
