package entity;

public class leibie {
    private Integer id;
    private String name;
    private Integer leibie_id;

    public leibie() {
    }


    public leibie(Integer id, String name, Integer leibie_id) {
        this.id=id;
        this.name = name;
        this.leibie_id = leibie_id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeibie_id() {
        return leibie_id;
    }

    public void setLeibie_id(Integer leibie_id) {
        this.leibie_id = leibie_id;
    }
}
