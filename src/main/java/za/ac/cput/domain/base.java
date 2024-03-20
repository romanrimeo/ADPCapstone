package za.ac.cput.domain;

import java.util.Objects;

public class base
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
        private final base base;
        public Builder()
        {
            base = new base();
        }

        public Builder id(Long id)
        {
            base.id = id;
            return this;
        }

        public base build()
        {
            return base;
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        base that = (base) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}

