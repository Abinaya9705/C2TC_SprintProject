<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

- This is a Spring Boot 3 + Thymeleaf app. Prefer Spring MVC patterns, DTOs for forms, and JPA repositories.
- Entities: College -> Department -> Batch; Student belongs to College, Department, Batch.
- Provide REST endpoints for dynamic selects: /api/colleges/{id}/departments and /api/departments/{id}/batches.
- Use Tailwind via CDN in templates. Keep JS simple and inline.
