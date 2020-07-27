package example.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.log4j.Log4j;

import java.nio.ByteBuffer;


@ChannelHandler.Sharable
@Log4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx ,Object msg){
        ByteBuffer in = (ByteBuffer) msg;
        log.info("Service received: " + in.toString() );
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx ){
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx ,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

//    @Override
//    public void channelRead(final ChannelHandlerContext ctx, final Object obj)

}
