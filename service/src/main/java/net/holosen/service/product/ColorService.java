package net.holosen.service.product;

import net.holosen.dataaccess.entity.product.Color;
import net.holosen.dataaccess.repository.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepository repository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.repository = colorRepository;
    }

    public List<Color> readAll() {
        return repository.findAll();
    }

    public Color read(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Color create(Color color) throws Exception {
        modelValidation(color);
        color.setId(null);
        return repository.save(color);
    }

    public Color update(Color color) throws Exception {
        modelValidation(color);
        if (color.getId() == null || color.getId() <= 0) {
            throw new Exception("Please enter id");
        }
        Color oldData = read(color.getId());
        oldData.setHex(color.getHex());
        oldData.setName(color.getName());
        return repository.save(oldData);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    private static void modelValidation(Color color) throws Exception {
        if (color == null) {
            throw new Exception("Color is null");
        }
        if (color.getName() == null || color.getName().isEmpty()) {
            throw new Exception("Please enter name");
        }
        if (color.getHex() == null || color.getHex().isEmpty()) {
            throw new Exception("Please enter hex");
        }
    }
}
