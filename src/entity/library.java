package entity;

public class library {
    private Integer id;
    private String library_id;
    private String name;
    private Integer leibie_id;

    public library() {
    }

    public library(Integer id, String library_id, String name, Integer leibie_id) {
        this.id = id;
        this.library_id = library_id;
        this.name = name;
        this.leibie_id = leibie_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(String library_id) {
        this.library_id = library_id;
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

    @Override
    public String toString() {
        return "library{" +
                "id=" + id +
                ", library_id='" + library_id + '\'' +
                ", name='" + name + '\'' +
                ", leibie_id=" + leibie_id +
                '}';
    }
}
