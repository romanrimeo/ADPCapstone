package za.ac.cput.domain;
import java.util.Objects;
public class baseclass
{
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public static class Builder
    {
        private final baseclass base;
        public Builder()
        {
            base = new baseclass();
        }

        public Builder id(Long id)
        {
            base.id = id;
            return this;
        }

        public baseclass build()
        {
            return base;
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        baseclass that = (baseclass) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
