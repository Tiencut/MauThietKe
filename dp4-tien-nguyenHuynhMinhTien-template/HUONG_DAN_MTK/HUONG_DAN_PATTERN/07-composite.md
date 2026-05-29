# 07 - Composite

## Khái niệm
Composite cho phép gom đối tượng thành cây và xử lý đồng nhất cả node và leaf.

## Khi nào dùng
- Có cấu trúc cây: thư mục, menu, tổ chức, danh mục.
- Muốn thao tác 1 lần cho cả nhóm hoặc từng phần tử.

## Dấu hiệu nhận biết đề thi
- Đề nói cha-con, cây thư mục, sản phẩm gồm nhiều cấp.
- Đề mô tả “một cái có thể chứa nhiều cái khác”.

## Vai trò class/interface
- `Component`: giao diện chung.
- `Leaf`: node lá, không chứa con.
- `Composite`: node cha, chứa danh sách component con.

## Thứ tự tạo file
1. Tạo interface chung.
2. Tạo Leaf.
3. Tạo Composite có danh sách con.
4. Dùng đệ quy duyệt cây.

## Flow hoạt động
`Client -> Composite -> gọi xuống Leaf/Composite con -> in kết quả`

## ASCII sơ đồ
```text
Component
  |
  +-- Leaf
  +-- Composite
        |
        +-- Leaf
        +-- Composite
```

## Skeleton code
```java
import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void show();
}

class FileItem implements FileSystemItem {
    private final String name;

    public FileItem(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name);
    }
}

class FolderItem implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public FolderItem(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void show() {
        System.out.println(name);
        for (FileSystemItem child : children) {
            child.show();
        }
    }
}
```

## Ví dụ đề thi
- Cây thư mục sản phẩm.
- Menu có submenu.

## Checklist code nhanh lúc thi
- [ ] Có interface chung
- [ ] Leaf không chứa con
- [ ] Composite có danh sách con
- [ ] Duyệt đệ quy
