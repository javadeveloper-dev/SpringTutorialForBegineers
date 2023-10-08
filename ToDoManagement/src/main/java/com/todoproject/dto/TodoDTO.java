package com.todoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

		private Long id;
		private String title;
		private String description;
		private boolean isCompleted;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isCompleted() {
			return isCompleted;
		}
		public void setCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
		}
		public TodoDTO() {
			super();
		}
		public TodoDTO(Long id, String title, String description, boolean isCompleted) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.isCompleted = isCompleted;
		}
		@Override
		public String toString() {
			return "TodoDTO [id=" + id + ", title=" + title + ", description=" + description + ", isCompleted="
					+ isCompleted + "]";
		}
}


