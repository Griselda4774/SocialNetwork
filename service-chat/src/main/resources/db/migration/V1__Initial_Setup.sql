CREATE TABLE message_type (
    message_type_id TINYINT PRIMARY KEY,
    name_en VARCHAR(20) NOT NULL,
    name_vn NVARCHAR(20) NOT NULL
)

CREATE TABLE [conversations] (
    [id] bigint PRIMARY KEY IDENTITY(1,1),
    [user1_id] bigint,
    [user2_id] bigint,
    [unread_count] int,
    CONSTRAINT uq_user_pair UNIQUE ([user1_id], [user2_id])
)
GO

CREATE TABLE [messages] (
    [id] bigint PRIMARY KEY IDENTITY(1,1),
    [content] nvarchar(MAX),
    [message_type_id] TINYINT,
    [url] varchar(255),
    [author_id] bigint,
    [conversation_id] bigint,
    [is_revoke] bit DEFAULT (0),
    [is_seen] bit DEFAULT (0),
    [timestamp] datetime DEFAULT (GETDATE()),
    CONSTRAINT fk_messages_conversations FOREIGN KEY ([conversation_id]) REFERENCES [conversations] ([id]),
    CONSTRAINT fk_posts_message_type FOREIGN KEY (message_type_id) REFERENCES message_type (message_type_id) ON DELETE SET NULL
)
GO

CREATE TABLE [deleted_messages] (
    [id] bigint PRIMARY KEY IDENTITY(1,1),
    [user_id] bigint NOT NULL,
    [conversation_id] bigint NOT NULL,
    [last_deleted_message_id] bigint NULL,
    FOREIGN KEY ([conversation_id]) REFERENCES [conversations] ([id]) ON DELETE CASCADE
);

