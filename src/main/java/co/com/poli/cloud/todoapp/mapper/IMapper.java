package co.com.poli.cloud.todoapp.mapper;

public interface IMapper<I,O> {
    public O map(I in);
}
