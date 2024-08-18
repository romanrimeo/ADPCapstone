//package za.ac.cput.service;
//
//import jakarta.persistence.Id;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.domain.RoomType;
//import za.ac.cput.repository.RoomTypeRepository;
//
//import java.util.List;
//
//public class RoomTypeSevice
//{
//    private RoomTypeRepository repository;
//    @Autowired
//    RoomTypeSevice(RoomTypeRepository repository)
//    {
//        this.repository = repository;
//    }
//
//    @Override
//    public RoomType create(RoomType roomType)
//    {
//        return repository.create(roomType);
//    }
//
//    @Override
//    public RoomType read(Id id)
//    {
//        return repository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<RoomType> getAll()
//    {
//        return repository.findAll();
//    }
//
//
//
//}
