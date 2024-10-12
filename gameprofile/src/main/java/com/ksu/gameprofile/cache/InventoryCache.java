package com.ksu.gameprofile.cache;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ksu.gameprofile.model.Inventory;
import com.ksu.gameprofile.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Component
public class InventoryCache extends Cache<Inventory> {

    private final static Logger logger = Logger.getLogger(InventoryCache.class.getName());
    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryCache() {
        super();
        this.setSupplier(getSupplier());
    }

    private Function<CacheKey, Inventory> getSupplier() {
        return new Function<CacheKey, Inventory>() {
            @Override
            public Inventory apply(CacheKey cacheKey) {
                try {
                   return inventoryRepository.findByInventoryId(((InventoryCacheKey)cacheKey).getInventoryId());
                } catch (Exception e) {
                    logger.log(Level.WARNING, e, () -> "Error receiving Inventory from db");
                    return null;
                }
            }
        };
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class InventoryCacheKey implements CacheKey {
        private long inventoryId;
    }

}
