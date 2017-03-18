package com.utils;

/**
 * Created by Administrator on 2017/3/15.
 * *    EncryptException is an exception class from exception, handles any exceptions that
 *    may happen in the encryption/descryption.
 */
public class EncryptException extends Exception{
    /**
     *  Construct a new EncryptException
     */
    public EncryptException() {
        super();
    }

    /**
     *  Construct a new EncryptException
     *  @param msg exception message
     */
    public EncryptException( String msg ) {
        super( msg );
    }

    /**
     *  Construct a new EncryptException
     *  @ex exception
     */
    public EncryptException( Throwable ex ) {
        super( ex );
    }
}
