package com.example.demo.services;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
  public void init();
  public String save(MultipartFile file);
  public Resource load(String filename);
  public void deleteAll();

  public void deleteByPath(String absolutePath);
  public Stream<Path> loadAll();
}