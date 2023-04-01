package com.example.mvpkotlindemo.data

import com.example.mvpkotlindemo.data.network.RemoteInterface
import com.example.mvpkotlindemo.data.room.LocalInteface

interface RepositoryInteface: RemoteInterface, LocalInteface {
}