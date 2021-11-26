package com.example.hotelapi.service.impl;

import com.example.hotelapi.exceptions.FileNotReadableException;
import com.example.hotelapi.service.spec.FileService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public byte[] compress(byte[] input) {

        Deflater compresseur = new Deflater();
        compresseur.setInput( input );
        compresseur.finish();

        byte[] buffer = new byte[1024];
        byte[] result = null;

        try( ByteArrayOutputStream outputStream = new ByteArrayOutputStream(input.length) ){

            while( !compresseur.finished() ){
                compresseur.deflate( buffer );
                outputStream.write( buffer );
            }

            compresseur.end();
            result = outputStream.toByteArray();

        }catch (IOException ex){
            throw new FileNotReadableException();
        }

        return result;
    }

    @Override
    public byte[] decompress(byte[] input) {

        Inflater decompresseur = new Inflater();
        decompresseur.setInput(input);

        byte[] buffer = new byte[1024];
        byte[] result = null;

        try ( ByteArrayOutputStream outputStream = new ByteArrayOutputStream() ){

            while( !decompresseur.finished() ){
                decompresseur.inflate( buffer );
                outputStream.write(buffer);
            }

            decompresseur.end();
            result = outputStream.toByteArray();

        }catch (IOException | DataFormatException ex){
            throw new FileNotReadableException();
        }

        return result;
    }
}
