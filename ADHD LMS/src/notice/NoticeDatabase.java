package notice;

import common.code.MyDbConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class NoticeDatabase {

    private static final String GET_NOTICES_QUERY = "SELECT NoticeID, Title, Content, Attachment FROM notice WHERE userid = ? ORDER BY NoticeID DESC";

    public static List<Notice> getNotices(int id) {
        List<Notice> notices = new ArrayList<>();

        try (Connection conn = new MyDbConnector().getMyConnection();
             PreparedStatement pstmt = conn.prepareStatement(GET_NOTICES_QUERY)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Blob blob = rs.getBlob("attachment");
                    InputStream is = blob.getBinaryStream();
                    File tempFile = File.createTempFile("attachment", ".pdf");
                    try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                        byte[] buffer = new byte[1024];
                        while (is.read(buffer) > 0) {
                            fos.write(buffer);
                        }
                    }

                    Notice notice = new Notice(rs.getString("title"), rs.getString("content"), tempFile.toURI().toString());
                    notices.add(notice);
                }
            }
        } catch (SQLException | IOException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }

        return notices;
    }
}

