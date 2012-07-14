
package com.trilead.ssh2.packets;

/**
 * PacketSessionEnvironmentVariable.
 *
 * @author Daniel Drown, dan-android@drown.org
 * @version $Id$
 */
public class PacketSessionEnvironmentVariable
{
	byte[] payload;

	public int recipientChannelID;
	public boolean wantReply;
        public String name;
        public String value;

	public PacketSessionEnvironmentVariable(int recipientChannelID, boolean wantReply, String name, String value)
	{
		this.recipientChannelID = recipientChannelID;
		this.wantReply = wantReply;
                this.name = name;
                this.value = value;
	}

	public byte[] getPayload()
	{
		if (payload == null)
		{
			TypesWriter tw = new TypesWriter();
			tw.writeByte(Packets.SSH_MSG_CHANNEL_REQUEST);
			tw.writeUINT32(recipientChannelID);
			tw.writeString("env");
			tw.writeBoolean(wantReply);
                        tw.writeString(name);
                        tw.writeString(value);
			payload = tw.getBytes();
		}
		return payload;
	}
}
