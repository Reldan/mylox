cmake_minimum_required(VERSION 3.10)
project(c C)

set(CMAKE_C_STANDARD 11)

add_executable(c main.c
        common.h
        chunk.h
        chunk.c
        memory.h
        memory.c
        debug.h
        debug.c
        value.h
        value.c
        vm.h
        vm.c)
