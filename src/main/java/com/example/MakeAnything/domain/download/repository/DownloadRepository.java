package com.example.MakeAnything.domain.download.repository;

import com.example.MakeAnything.domain.download.model.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
}
