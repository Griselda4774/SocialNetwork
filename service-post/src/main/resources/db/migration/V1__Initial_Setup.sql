CREATE TABLE privacy_types (
                               privacy_type_id TINYINT PRIMARY KEY,
                               name_en VARCHAR(20) NOT NULL,
                               name_vn NVARCHAR(20) NOT NULL
);

CREATE TABLE url_types (
                           url_type_id TINYINT PRIMARY KEY,
                           name_en VARCHAR(20) NOT NULL,
                           name_vn NVARCHAR(20) NOT NULL
);

CREATE TABLE like_types (
                            like_type_id TINYINT PRIMARY KEY,
                            name_en VARCHAR(20) NOT NULL,
                            name_vn NVARCHAR(20) NOT NULL
);

CREATE TABLE posts (
                       post_id BIGINT PRIMARY KEY IDENTITY(1,1),
                       content NVARCHAR(MAX),
                       url VARCHAR(255),
                       privacy_type_id TINYINT,
                       url_type_id TINYINT,
                       created_at DATETIME2 DEFAULT GETDATE(),
                       updated_at DATETIME2 DEFAULT GETDATE(),
                       author_id BIGINT,
                       page_id BIGINT,
                       likes INT DEFAULT 0,
                       CONSTRAINT fk_posts_privacy_types FOREIGN KEY (privacy_type_id) REFERENCES privacy_types (privacy_type_id) ON DELETE SET NULL,
                       CONSTRAINT fk_posts_url_types FOREIGN KEY (url_type_id) REFERENCES url_types (url_type_id) ON DELETE SET NULL
);

CREATE TABLE comments (
                          comment_id BIGINT PRIMARY KEY IDENTITY(1,1),
                          content NVARCHAR(MAX),
                          created_at DATETIME2 DEFAULT GETDATE(),
                          updated_at DATETIME2 DEFAULT GETDATE(),
                          author_id BIGINT,
                          post_id BIGINT,
                          likes INT DEFAULT 0,
                          CONSTRAINT fk_comments_posts FOREIGN KEY (post_id) REFERENCES posts (post_id) ON DELETE CASCADE
);

CREATE TABLE stories (
                         story_id BIGINT PRIMARY KEY IDENTITY(1,1),
                         content NVARCHAR(MAX),
                         image_url VARCHAR(255),
                         url_type_id TINYINT,
                         privacy_type_id TINYINT,
                         author_id BIGINT,
                         created_at DATETIME2 DEFAULT GETDATE(),
                         likes INT DEFAULT 0,
                         views INT DEFAULT 0,
                         CONSTRAINT fk_stories_url_types FOREIGN KEY (url_type_id) REFERENCES url_types (url_type_id) ON DELETE SET NULL,
                         CONSTRAINT fk_stories_privacy_types FOREIGN KEY (privacy_type_id) REFERENCES privacy_types (privacy_type_id) ON DELETE SET NULL
);

CREATE TABLE likes (
                       like_id BIGINT PRIMARY KEY IDENTITY(1,1),
                       target_id BIGINT,
                       user_id BIGINT,
                       like_type_id TINYINT,
                       CONSTRAINT fk_likes_like_types FOREIGN KEY (like_type_id) REFERENCES like_types (like_type_id) ON DELETE SET NULL,
                       CONSTRAINT uq_likes_target_type_user UNIQUE (target_id, user_id, like_type_id)
);

CREATE TABLE views (
                       view_id BIGINT PRIMARY KEY IDENTITY(1,1),
                       story_id BIGINT,
                       user_id BIGINT,
                       CONSTRAINT fk_views_stories FOREIGN KEY (story_id) REFERENCES stories (story_id) ON DELETE CASCADE
);
