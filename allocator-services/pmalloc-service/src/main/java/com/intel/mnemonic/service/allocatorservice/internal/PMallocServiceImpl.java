package com.intel.mnemonic.service.allocatorservice.internal;

import com.intel.mnemonic.service.allocatorservice.NonVolatileMemoryAllocatorService;
import org.flowcomputing.commons.primitives.*;
import java.nio.ByteBuffer;


public class PMallocServiceImpl implements NonVolatileMemoryAllocatorService {
    static {
        try {
            NativeLibraryLoader.loadFromJar("pmallocallocator");
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public long init(long capacity, String uri, boolean isnew) {
        return ninit(capacity, uri, isnew);
    }


    public void close(long id) {
        nclose(id);
    }


    public void sync(long id) {
        nsync(id);
    }


    public long allocate(long id, long size, boolean initzero) {
        return nallocate(id, size, initzero);
    }


    public long reallocate(long id, long address, long size, boolean initzero) {
        return nreallocate(id, address, size, initzero);
    }


    public void free(long id, long address) {
        nfree(id, address);
    }


    public ByteBuffer createByteBuffer(long id, long size) {
        return ncreateByteBuffer(id, size);
    }


    public  ByteBuffer resizeByteBuffer(long id, ByteBuffer bytebuf, long size) {
        return nresizeByteBuffer(id, bytebuf, size);
    }

    public void destroyByteBuffer(long id, ByteBuffer bytebuf) {
        ndestroyByteBuffer(id, bytebuf);
    }

    public ByteBuffer retrieveByteBuffer(long id, long handler) {
        return nretrieveByteBuffer(id, handler);
    }

    public long retrieveSize(long id, long handler) {
        return nretrieveSize(id, handler);
    }
	
    public long getByteBufferHandler(long id, ByteBuffer buf) {
        return ngetByteBufferHandler(id, buf);
    }

    public void setHandler(long id, long key, long handler) {
        nsetHandler(id, key, handler);
    }
	
    public long getHandler(long id, long key) {
        return ngetHandler(id, key);
    }
	
    public long handlerCapacity(long id) {
        return nhandlerCapacity(id);
    }
		
    public long getBaseAddress(long id) {
        return ngetBaseAddress(id);
    }

    protected native long ninit(long capacity, String uri, boolean isnew);


    protected native void nclose(long id);


    protected native void nsync(long id);


    protected native long nallocate(long id, long size, boolean initzero);


    protected native long nreallocate(long id, long address, long size, boolean initzero);


    protected native void nfree(long id, long address);


    protected native ByteBuffer ncreateByteBuffer(long id, long size);


    protected native ByteBuffer nresizeByteBuffer(long id, ByteBuffer bytebuf, long size);
	

    protected native void ndestroyByteBuffer(long id, ByteBuffer bytebuf);
    

    protected native ByteBuffer nretrieveByteBuffer(long id, long handler);
    
    
    protected native long nretrieveSize(long id, long handler);
    

    protected native long ngetByteBufferHandler(long id, ByteBuffer buf);
    

    protected native void nsetHandler(long id, long key, long handler);
    

    protected native long ngetHandler(long id, long key);
    

    protected native long nhandlerCapacity(long id);
    

    protected native long ngetBaseAddress(long id);

    
}