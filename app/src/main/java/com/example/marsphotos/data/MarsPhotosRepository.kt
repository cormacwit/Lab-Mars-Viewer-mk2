package com.example.marsphotos.data
import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApi.retrofitService
import com.example.marsphotos.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

// NetworkMarsPhotosRepository class
import com.example.marsphotos.network.MarsApi

class NetworkMarsPhotosRepository(private val marsApiService: MarsApiService) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}

// MarsViewModel update

val marsPhotosRepository = NetworkMarsPhotosRepository(retrofitService)
val listResult = marsPhotosRepository.getMarsPhotos()


