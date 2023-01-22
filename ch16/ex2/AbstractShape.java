package gr.aueb.cf.oop.ch16.ex2;

public abstract class AbstractShape implements IShape {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
