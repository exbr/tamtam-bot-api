/*
 * ------------------------------------------------------------------------
 * TamTam chat Bot API
 * ------------------------------------------------------------------------
 * Copyright (C) 2018 Mail.Ru Group
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ------------------------------------------------------------------------
 */

package chat.tamtam.botapi.queries.upload;

import java.io.File;
import java.io.InputStream;

import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.model.UploadedInfo;

/**
 * @author alexandrchuprin
 */
public class TamTamUploadAVQuery extends TamTamUploadQuery<UploadedInfo> {
    public TamTamUploadAVQuery(TamTamClient tamTamClient, String url, File file) {
        super(tamTamClient, UploadedInfo.class, url, file);
    }

    public TamTamUploadAVQuery(TamTamClient tamTamClient, String url, String fileName, InputStream input) {
        super(tamTamClient, UploadedInfo.class, url, fileName, input);
    }
}
